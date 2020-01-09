package repetition;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Projects {
    List<ProjectsFounds> projects = new ArrayList<>(
            Arrays.asList(
                    new ProjectsFounds("SmartCity", 1_500_000.,20,80.,"IT", 36),
                    new ProjectsFounds("IClare", 2_750_000.,15,60.,"Engineering", 48),
                    new ProjectsFounds("eEducation", 500_000.,5,100.,"Education", 12),
                    new ProjectsFounds("Mobile ecosystems", 850_000.,12,80.,"IT", 36),
                    new ProjectsFounds("GreenWave", 3_500_000.,100,90.,"IT", 56),
                    new ProjectsFounds("NLP", 1_000_000.,8,55.,"IT", 36)
            )
    );
}
