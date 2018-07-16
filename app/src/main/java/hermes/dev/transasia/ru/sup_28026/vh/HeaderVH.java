package hermes.dev.transasia.ru.sup_28026.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hermes.dev.transasia.ru.sup_28026.R;

public class HeaderVH extends RecyclerView.ViewHolder {

    public TextView tvTitle;


    public HeaderVH(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }
}
