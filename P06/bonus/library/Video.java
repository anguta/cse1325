package library;

import java.time.Duration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
            throw new InvalidRuntimeException("Runtime", runtime);
        }
        this.runtime = Duration.ofMinutes(runtime);
    }
    /**
    * Calls superclass constructor to restore fields, creates a new Duration object to runtime
    * @param br where we are reading from
    * @throws IOException when something we access isn't in the file or there is there is improper data
    * @since 1.3
    *
    */
    public Video(BufferedReader br) throws IOException {
        super(br);
        
        this.runtime = Duration.ofMinutes(Long.parseLong(br.readLine()));
    }
    /**
    * Chains to superclass save method and writes runtime value to the field
    * @param bw where we are writing to
    * @throws IOException when something we access isn't in the file or there is improper data
    * @since 1.3
    *
    */
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        
        bw.write(runtime.toMinutes() + "\n");
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
