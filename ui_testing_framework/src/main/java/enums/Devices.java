package enums;

public enum Devices {
    Iphone15("iphone15", "iPhone", "00028334-0118238AC4442201R", "17.1.2");

    private String OSversion;
    private String deviceModel;
    private String deviceName;
    private String udid;


    Devices(String deviceModel, String deviceName, String udid, String osVersion) {
        this.deviceModel = deviceModel;
        this.deviceName = deviceName;
        this.udid = udid;
        this.OSversion = osVersion;
    }

    public static Devices getElementByValue(String deviceModel) {
        for (Devices enumElement : values()) {
            if (enumElement.deviceModel.equals(deviceModel.toLowerCase().replaceAll("\\s+", ""))) {
                return enumElement;
            }
        }
        return null;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public String getOSversion() {
        return OSversion;
    }

}
