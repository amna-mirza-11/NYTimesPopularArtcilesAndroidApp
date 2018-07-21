package ae.sample.nytimesarticles.ui.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import ae.sample.nytimesarticles.R;
import ae.sample.nytimesarticles.model.PopularArticles;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DetailArticleFragment extends Fragment {

    private Unbinder unbinder;
    private static final String ARTICLE_URL = "article_url";
    private String articleURLPath;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.wv_article_detail)
    WebView wv_articleDetails;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.pb_spin)
    ProgressBar pb_spin;

    public static DetailArticleFragment newInstance(PopularArticles popularArticles) {
        DetailArticleFragment detailArticleFragment = new DetailArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARTICLE_URL, popularArticles.getUrl());
        detailArticleFragment.setArguments(args);
        return detailArticleFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            articleURLPath = getArguments().getString(ARTICLE_URL);
        else
            articleURLPath = "https://www.google.com";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        initializeUI();
        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initializeUI() {
        pb_spin.setVisibility(View.VISIBLE);
        wv_articleDetails.getSettings().setJavaScriptEnabled(true);
        wv_articleDetails.setWebViewClient(new ArticleBrowser());
        wv_articleDetails.loadUrl(articleURLPath);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb_spin.setVisibility(View.INVISIBLE);
            }
        }, 1500);
    }

    public class ArticleBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
