package wikitests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;


public class WikipediaAndroidTests extends TestBase {

  @Tag("android")
  @Test
  @DisplayName("Check main texts on 4 screens")
  void checkPrimaryTextsOnScreens() {

    step("Check text on first screen", () -> {
      wikiOnBoardingPage.shouldHavePrimaryText(wikiOnBoardingPage.textOnFirstScreen);
    });

    step("Click on 'continue' button", () ->{
            wikiOnBoardingPage.clickContinueButton();});

    step("Check text on second screen", () -> {
      wikiOnBoardingPage.shouldHavePrimaryText(wikiOnBoardingPage.textOnSecondScreen);
    });

    step("Click on 'continue' button", () ->{
            wikiOnBoardingPage.clickContinueButton();});

    step("Check text on third screen", () -> {
      wikiOnBoardingPage.shouldHavePrimaryText(wikiOnBoardingPage.textOnThirdScreen);
    });

    step("Click on 'continue' button", () ->{
            wikiOnBoardingPage.clickContinueButton();});

    step("Check text on fourth screen", () -> {
      wikiOnBoardingPage.shouldHavePrimaryText(wikiOnBoardingPage.textOnFourthScreen);
    });
  }

  @Tag("android")
  @Test
  @DisplayName("Add German language to Wikipedia")
  void addLanguageOnFirstScreen() {

    step("Click on button 'add or edit languages'", () -> {
      wikiAddLanguagesPage.clickAddOrEditLanguages();
    });

    step("Click on button 'add language'", () -> {
      wikiAddLanguagesPage.clickAddLanguage();
    });

    step("Choose German language", () -> {
      wikiAddLanguagesPage.addGermanLanguage();
    });

    step("Check that German was added to languages list", () -> {
      wikiAddLanguagesPage.checkListOfAddedLanguages();
    });

    step("Go back to first screen", () -> {
      wikiAddLanguagesPage.clickBackButton();
    });

    step("Check that list of languages was increased to 2 items", () -> {
      wikiAddLanguagesPage.checkTheSizeOfLanguagesList();
    });
  }
}




