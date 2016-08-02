package tw.com.softworld.bluetoothconnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Catherine on 2016/8/2.
 * Soft-World Inc.
 * catherine919@soft-world.com.tw
 */
public class BluetoothVendor {
    private final static String TAG = "BluetoothVendor";
    private final static String URL = "http://api.macvendors.com/";
    private static HashMap<String, String> resultMap;

    /**
     * Refer to http://www.macvendors.com/api
     *
     * @param address
     * @param handler
     */
    public static void getVendor(final String name, final String address, final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String content = "";
                resultMap = new HashMap<>();
                try {
                    resultMap.put("MAC_ADDRESS", address);
                    if (name != null)
                        resultMap.put("NAME", name);
                    else
                        resultMap.put("NAME", "NO NAME");
                    java.net.URL url = new URL(URL + address);
                    Log.d(TAG, URL + address);
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    // 5秒
                    conn.setReadTimeout(5000);
                    conn.setRequestMethod("GET");

                    int code = conn.getResponseCode();
                    if (code == 200) {
                        InputStream is = conn.getInputStream();
                        byte[] result = getBytes(is);
                        content = new String(result);
                        resultMap.put("VENDOR", content);
                        sendMessage(Constants.SUCCESS, handler);
                    } else {
                        sendMessage(Constants.FAILURE, handler);
                        Log.e(TAG, "Failed to get vendor:" + code);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, "Exception " + e);
                    sendMessage(Constants.FAILURE, handler);
                }

            }
        }).start();

    }

    /**
     * Transform InputStream to byte[]
     *
     * @param is
     * @return
     * @throws Exception
     */
    private static byte[] getBytes(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        is.close();
        bos.flush();
        byte[] result = bos.toByteArray();
        return result;
    }

    /**
     * Push message to myHandler
     *
     * @param msgCode
     * @param handler
     */
    private static void sendMessage(int msgCode, Handler handler) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("MSG", resultMap);
        msg.setData(bundle);
        msg.what = msgCode;
        handler.sendMessage(msg);
    }
}
