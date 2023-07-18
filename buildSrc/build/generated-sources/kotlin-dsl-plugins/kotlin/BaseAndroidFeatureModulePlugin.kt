/**
 * Precompiled [base-android-feature-module.gradle.kts][Base_android_feature_module_gradle] script plugin.
 *
 * @see Base_android_feature_module_gradle
 */
public
class BaseAndroidFeatureModulePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Base_android_feature_module_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
