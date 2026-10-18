import conversion.MediaConversionFacade;

public class Main {
    public static void main(String[] args) {
        MediaConversionFacade facade = new MediaConversionFacade();

        try {
            System.out.println(facade.convert("song.mp3", "wav"));
            System.out.println();
            System.out.println(facade.convert("voice.wav", "mp3"));
        } catch (IllegalArgumentException error) {
            System.out.println("Conversion failed: " + error.getMessage());
        }
    }
}