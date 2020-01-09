package repetition;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Projects {
    List<Project> projects = new ArrayList<>(
            Arrays.asList(
                    new ProjectsFounds("SmartCity", 1_500_000.,20,80.,"IT", Month.of(36)),
                    new ProjectsFounds("IClare", 2_750_000.,15,60.,"Engineering", Month.of(48)),
                    new ProjectsFounds("eEducation", 500_000.,5,100.,"Education", Month.of(12)),
                    new ProjectsFounds("Mobile ecosystems", 850_000.,12,80.,"IT", Month.of(36)),
                    new ProjectsFounds("GreenWave", 3_500_000.,100,90.,"IT", Month.of(56)),
                    new ProjectsFounds("NLP", 1_000_000.,8,55.,"IT", Month.of(36))
            )
    );
}
