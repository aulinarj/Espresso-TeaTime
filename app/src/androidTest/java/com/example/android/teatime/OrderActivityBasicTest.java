package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Aulina on 06/02/2018.
 */

@RunWith(AndroidJUnit4.class)

public class OrderActivityBasicTest {

    @Rule

    public ActivityTestRule<OrderActivity> mActivityTestRule =
            new ActivityTestRule<>(OrderActivity.class);

    @Test

    public void clickDecrementButton_ChangeActivityAndCost() {
        //Check the initial quantity variable is zero
        onView((withId(R.id.quantity_text_view))).check(matches(withText(" 0 ")));

        //Check on decrement button
        onView((withId(R.id.decrement_button))).perform(click());

        //Verivy thet the decrement button decrease the quantity by 1
        onView(withId(R.id.quantity_text_view)).check(matches(withText(" 0 ")));

        //Verivy that the increment button also increases the total cost to $5.00
        onView(withId(R.id.cost_text_view)).check(matches(withText(" $0.00 ")));
    }
}

