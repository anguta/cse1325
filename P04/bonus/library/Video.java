package library;

import java.time.Duration;

/**
 *  A Video publication that can be checked out
 * @author Angel Cabrera
 * @version 1.0
 * @since 1.0
 *
 */
public class Video extends Publication{

    private Duration runtime;
    /**
    * Constructs a new Video with the title, author, copyright year and the Video's runtime
    * @param title The title of the video
    * @param author The author of the video
    * @param copyright The copyright year of the video
    * @param runtime The runtime of the video in minutes
    * @throws InvalidRuntimeException when runtime is less than or equal to zero
    * @since 1.0
    *
    */
    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime <= 0) {
            throw new InvalidRuntimeException("Invalid Runtime");
        }
        this.runtime = Duration.ofMinutes(runtime);
    }
    /**
    * Returns Video and runtime to toStringBuilder
    *
    * @return A string value of the video and runtime
    * @since 1.0
    */
    @Override
    public String toString() {
        String result = "Runtime: " + runtime.toMinutes() + " minutes";
        return toStringBuilder("Video", result);
        
    }
}
