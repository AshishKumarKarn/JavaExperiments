package karn.ashish.type4;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
@interface WinWordSpellChecker {
}
@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
@interface SimpleSpellChecker {
}

public class GuiceTester {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor editor = injector.getInstance(TextEditor.class);
        editor.makeSpellCheck();
    }
}

class TextEditor {
    private SpellChecker wSpellChecker;
    private SpellChecker spellChecker;

    @Inject
    public TextEditor(@WinWordSpellChecker SpellChecker wSpellChecker,@SimpleSpellChecker SpellChecker spellChecker) {
        this.wSpellChecker = wSpellChecker;
        this.spellChecker = spellChecker;
    }

    public void makeSpellCheck() {
        spellChecker.checkSpelling();
        wSpellChecker.checkSpelling();
    }
}

//Binding Module
class TextEditorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SpellChecker.class).annotatedWith(WinWordSpellChecker.class)
                .to(WinWordSpellCheckerImpl.class);
        bind(SpellChecker.class).annotatedWith(SimpleSpellChecker.class)
                .to(SpellCheckerImpl.class);
    }
}

//spell checker interface
interface SpellChecker {
    public void checkSpelling();
}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling.");
    }
}

//subclass of SpellCheckerImpl
class WinWordSpellCheckerImpl extends SpellCheckerImpl {
    @Override
    public void checkSpelling() {
        System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling.");
    }
}