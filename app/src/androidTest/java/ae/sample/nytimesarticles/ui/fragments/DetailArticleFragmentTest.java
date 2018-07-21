package ae.sample.nytimesarticles.ui.fragments;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ae.sample.nytimesarticles.R;
import ae.sample.nytimesarticles.ui.activities.MainActivity;
import static org.junit.Assert.*;

public class DetailArticleFragmentTest {
    @SuppressWarnings("CanBeFinal")
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity  = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void onCreateView() throws Exception {

        View view = mainActivity.findViewById(R.id.articlesFragment);
        assertNotNull(view);
        DetailArticleFragment detailArticleFragment = new DetailArticleFragment();
        mainActivity.getFragmentManager().beginTransaction().add(view.getId(), detailArticleFragment).commitAllowingStateLoss();

    }


    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }


}