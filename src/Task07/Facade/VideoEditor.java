package Task07.Facade;

public class VideoEditor {
    public static final int bitrate = 320;
    public static final int currentVolume = 1000;
    public static final int wantedVolume = 800;
    public static void MP4toAVI() {
        BitrateReader.readBitrate(bitrate);
        FormatConverter.convert("MP4", "avi");
    }

    public static void lowerVolume() {
        BitrateReader.readBitrate(bitrate);
        AudioMixer.lowerVolumeBy(currentVolume - wantedVolume);
    }
}
