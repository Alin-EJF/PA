package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


 //RetentionPolicy.RUNTIME: The annotations annotated using the RUNTIME retention policy are retained during runtime
 //and can be accessed in our program during runtime

@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
