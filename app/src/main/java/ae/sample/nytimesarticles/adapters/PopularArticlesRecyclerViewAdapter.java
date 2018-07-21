package ae.sample.nytimesarticles.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import ae.sample.nytimesarticles.R;
import ae.sample.nytimesarticles.model.PopularArticles;
import ae.sample.nytimesarticles.presenter.ArticleClickListener;
import ae.sample.nytimesarticles.ui.fragments.ArticlesListFragment;
import butterknife.BindView;
import butterknife.ButterKnife;


public class PopularArticlesRecyclerViewAdapter extends RecyclerView.Adapter<PopularArticlesRecyclerViewAdapter.MyViewHolder> {

    private final List<PopularArticles> popularArticles;
    private final ArticleClickListener articleClickListener;

    public PopularArticlesRecyclerViewAdapter(List<PopularArticles> articlesList, ArticlesListFragment clickListener) {
        popularArticles = articlesList;
        articleClickListener = clickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_articles_details_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.tvArticleTitle.setText(popularArticles.get(position).getTitle());
        holder.tvArticleDetail.setText(popularArticles.get(position).getByline());
        holder.tvArticleSource.setText(popularArticles.get(position).getSource());
        holder.tvArticleDate.setText(popularArticles.get(position).getPublishedDate());
        holder.imgArticleIcon.setImageUrl(popularArticles.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl());

        holder.cvAgentItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articleClickListener.onArticleCardClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularArticles.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_article_icon)
        com.androidnetworking.widget.ANImageView imgArticleIcon;
        @BindView(R.id.tv_article_title)
        TextView tvArticleTitle;
        @BindView(R.id.tv_article_detail)
        TextView tvArticleDetail;
        @BindView(R.id.tv_article_source)
        TextView tvArticleSource;
        @BindView(R.id.tv_article_date)
        TextView tvArticleDate;
        @BindView(R.id.ll_details)
        RelativeLayout llDetails;
        @BindView(R.id.iv_details)
        ImageView ivDetails;
        @BindView(R.id.cvAgentItemContainer)
        CardView cvAgentItemContainer;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
