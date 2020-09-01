import java.util.ArrayList;

public class Phone {
    private final String brand;
    private final String model;
    private int displayX;
    private int displayY;
    private int messageStorage;
    private ArrayList<String> messages;
    private int photoStorage;
    private int appStorage;
    private int photoPlusAppStorage = photoStorage + appStorage;
    private int usedStorage;
    private int nStoredPhotos;
    private int nInstalledApps;
    private ArrayList<String> installedApps;

    public Phone(String brand, String model, int x, int y, int messageStorage, ArrayList<String> messages, int photoStorage, int appStorage) {
        this.brand = brand;
        this.model = model;
        this.displayX = x;
        this.displayY = y;
        this.messageStorage = messageStorage;
        this.messages = new ArrayList<String>(messages.size());
        for(String message : messages) this.messages.add(message);
        this.photoStorage = photoStorage;
        this.appStorage = appStorage;
        this.usedStorage = 0;
        this.nStoredPhotos = 0;
        this.nInstalledApps = 0;
        this.installedApps = new ArrayList<String>(nInstalledApps);
    }

    public Phone(String brand, String model, int x, int y, int messageStorage, ArrayList<String> messages, int photoStorage, int appStorage, int usedStorage, int nStoredPhotos, int nInstalledApps, ArrayList<String> installedApps) {
        this.brand = brand;
        this.model = model;
        this.displayX = x;
        this.displayY = y;
        this.messageStorage = messageStorage;
        this.messages = new ArrayList<String>(messages.size());
        for(String message : messages) this.messages.add(message);
        this.photoStorage = photoStorage;
        this.appStorage = appStorage;
        this.usedStorage = usedStorage;
        this.nStoredPhotos = nStoredPhotos;
        this.nInstalledApps = nInstalledApps;
        this.installedApps = new ArrayList<String>(nInstalledApps);
        for(String app : installedApps) installedApps.add(app);
    }

    public Phone(Phone phone) {
        this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.displayX = phone.getDisplayX();
        this.displayY = phone.getDisplayY();
        this.messageStorage = phone.getMessageStorage();
        this.messages = new ArrayList<String>(phone.getMessages().size());
        for(String message : phone.getMessages()) this.messages.add(message);
        this.photoStorage = phone.getPhotoStorage();
        this.appStorage = phone.getAppStorage();
        this.usedStorage = phone.getUsedStorage();
        this.nStoredPhotos = phone.getnStoredPhotos();
        this.nInstalledApps = phone.getnInstalledApps();
        this.installedApps = new ArrayList<String>(this.nInstalledApps);
        for(String app : phone.getInstalledApps()) this.installedApps.add(app);
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = new ArrayList<String>(messages.size());
        for(String message : messages) this.messages.add(message);
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getDisplayX() {
        return this.displayX;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public int getDisplayY() {
        return this.displayY;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public int getMessageStorage() {
        return this.messageStorage;
    }

    public void setMessageStorage(int messageStorage) {
        this.messageStorage = messageStorage;
    }

    public int getPhotoPlusAppStorage() {
        return this.photoPlusAppStorage;
    }

    public void setPhotoPlusAppStorage(int photoPlusAppStorage) {
        this.photoPlusAppStorage = photoPlusAppStorage;
    }

    public int getPhotoStorage() {
        return this.photoStorage;
    }

    public void setPhotoStorage(int photoStorage) {
        this.photoStorage = photoStorage;
    }

    public int getAppStorage() {
        return this.appStorage;
    }

    public void setAppStorage(int appStorage) {
        this.appStorage = appStorage;
    }

    public int getUsedStorage() {
        return this.usedStorage;
    }

    public void setUsedStorage(int usedStorage) {
        this.usedStorage = usedStorage;
    }

    public int getnStoredPhotos() {
        return this.nStoredPhotos;
    }

    public void setnStoredPhotos(int nStoredPhotos) {
        this.nStoredPhotos = nStoredPhotos;
    }

    public int getnInstalledApps() {
        return this.nInstalledApps;
    }

    public ArrayList<String> getInstalledApps() {
        return this.installedApps;
    }

    public void setInstalledApps(int nInstalledApps, ArrayList<String> installedApps) {
        this.nInstalledApps = nInstalledApps;
        this.installedApps = new ArrayList<String>(nInstalledApps);
        for(String app : installedApps) this.installedApps.add(app);
    }

    public boolean isThereFreeStorageFor(int numberBytes) {
        return this.usedStorage + numberBytes < this.photoPlusAppStorage + this.messageStorage;
    }

    public void installApp(String name, int size) {
        this.nInstalledApps++;
        this.installedApps.add(name);
        this.appStorage += size;
    }

    public void receiveMsg(String msg) {
        this.usedStorage += msg.length();
    }

    public double avgAppSize() {
        return this.appStorage / this.nInstalledApps;
    }

    public String biggestMsg() {
        int biggestSize = Integer.MIN_VALUE;
        String answer = "";
        for(String message : this.messages) {
            if(message.length() > biggestSize) {
                biggestSize = message.length();
                answer = message;
            }
        }
        return answer;
    }

    public void removeApp(String name, int size) {
        this.appStorage -= size;
        this.nInstalledApps--;
        this.installedApps.remove(name);
    }
}
