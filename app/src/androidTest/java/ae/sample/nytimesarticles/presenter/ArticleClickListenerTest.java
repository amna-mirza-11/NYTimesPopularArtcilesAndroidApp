package ae.sample.nytimesarticles.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ae.sample.nytimesarticles.ui.activities.MainActivity;

import static org.junit.Assert.assertNotNull;


public class ArticleClickListenerTest {

    private ArticleClickListener articleClickListener;

    @Before
    public void setUp() throws Exception {
        articleClickListener = (ArticleClickListener) new MainActivity();
    }


    @Test
    public void onArticleCardClickListener() throws Exception {
        assertNotNull(articleClickListener);
    }

    @After
    public void tearDown() throws Exception {
        articleClickListener = null;
    }


}