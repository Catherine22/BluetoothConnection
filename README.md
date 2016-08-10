# BluetoothConnection
Refer to BluetoothChat

In [DeviceListActivity]

 - device.getBluetoothClass().getMajorDeviceClass()     
Get the Major to tell you what the device is.       
*Here is [Device.Major] definds all devices*
 - BluetoothVendor        
Find MAC Address Vendors to connect to an Android phone.        
*Refer to http://www.macvendors.com/*

 - Obtaine UUIDs from [The Bluetooth Assigned Numbers document] or use BASE_UUID(00000000-0000-1000-8000-00805F9B34FB)        
*Read more https://www.bluetooth.com/specifications/assigned-numbers/service-discovery*

[DeviceListActivity]: <https://github.com/JetAircraft/BluetoothConnection/blob/master/app/src/main/java/tw/com/softworld/bluetoothconnection/DeviceListActivity.java>
[Device.Major]:<https://developer.android.com/reference/android/bluetooth/BluetoothClass.Device.Major.html>
[The Bluetooth Assigned Numbers document]:<http://www.bluetooth.org/foundry/assignnumb/document/service_discovery>
