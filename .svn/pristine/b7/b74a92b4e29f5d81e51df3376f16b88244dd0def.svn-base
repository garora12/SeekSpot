package project.seasia.com.seekspot;

import android.app.DatePickerDialog;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.seasia.android.seekspot.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import activities.ActivityBirthDate;
import activities.ActivityLoginForm;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by sandhunavneet on 9/23/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {
    public static final String EMAIL="navneet_sandhu@gmail.com";
    public static final String PASSWORD="aaaaaaaa";
    public static final String MOBILENUMBER="9876543210";
    public static final String FIRSTNAME="Navneet";
    public static final String LASTNAME="Sandhu";
    @Rule
    public ActivityTestRule<ActivityLoginForm> mActivityTestRule=new ActivityTestRule<ActivityLoginForm>(ActivityLoginForm.class);

    @Test
    public void test(){
        onView(withId(R.id.ed_login_email)).perform(typeText(EMAIL),closeSoftKeyboard());
        onView(withId(R.id.ed_login_password)).perform(typeText(PASSWORD),closeSoftKeyboard());
        onView(withId(R.id.relSignUp)).perform(click());
        onView(withId(R.id.btn_signup_next)).perform(click());
        onView(withId(R.id.ed_mobphno_enter_mobno)).perform(typeText(MOBILENUMBER),closeSoftKeyboard());
        onView(withId(R.id.btn_mobphnno_next)).perform(click());
        onView(withId(R.id.ed_name_firstname)).perform(typeText(FIRSTNAME),closeSoftKeyboard());
        onView(withId(R.id.ed_name_lastname)).perform(typeText(LASTNAME),closeSoftKeyboard());
        onView(withId(R.id.btn_name_next)).perform(click());
        onView(withId(R.id.radio_gender_female)).perform(click());
        onView(withId(R.id.btn_gender_next)).perform(click());
        onView(withId(R.id.ed_birthday_set_date)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(9,3,2016));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.btn_birthday_next)).perform(click());
        onView(withId(R.id.et_email_enter_mailid)).perform(typeText(EMAIL),closeSoftKeyboard());
        onView(withId(R.id.btn_emailid_next)).perform(click());
        onView(withId(R.id.ed_choose_pswd_enter_password)).perform(typeText(PASSWORD),closeSoftKeyboard());
        onView(withId(R.id.btn_choose_pswd_next)).perform(click());
        onView(withId(R.id.ed_verify_email_enter_mailid)).perform(typeText(EMAIL),closeSoftKeyboard());
        onView(withId(R.id.btn_verify_emailid_verify)).perform(click());
        /*onView(withId(R.id.btn_term_cndtn_signup)).perform(click());
       /* onView(withId(R.id.img_login_twitter)).perform(click());
        onView(withId(R.id.btn_twitter_login_button)).perform(click());*/
      /*  onView(withClassName(Matchers.equalTo(Button.class.getName()))).perform((click()));
        onView(withText("Allow")).perform(click());
        onView(withId(R.id.btn_term_cndtn_signup)).perform(click());
*/


}
}
