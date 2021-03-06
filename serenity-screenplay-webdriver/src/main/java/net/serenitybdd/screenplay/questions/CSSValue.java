package net.serenitybdd.screenplay.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;
import static net.serenitybdd.screenplay.questions.UIFilter.visible;

public class CSSValue extends TargetedUIState<String> {

    private final String attributeName;

    public CSSValue(Target target, Actor actor, String attributeName) {
        super(target,actor);
        this.attributeName = attributeName;
    }

    public static UIStateReaderWithNameBuilder<CSSValue> of(Target target) {
        return new UIStateReaderWithNameBuilder(target, CSSValue.class);
    }

    public String resolve() {
        return target.resolveFor(actor).getCssValue(attributeName);
    }

    public List<String> resolveAll() {
        return extract(visible(target.resolveAllFor(actor)), on(WebElementFacade.class).getCssValue(attributeName));
    }
}
