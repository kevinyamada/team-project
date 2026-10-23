package use_case.discovery;

import entity.Photo;
import java.io.IOException;
import java.util.List;

/** Profile keys may represent board IDs or user IDs supplied by the owning use case. */
public interface PreferenceStore {
    List<Photo> load(String profile) throws IOException;
    void save(String profile, List<Photo> photos) throws IOException;
}
