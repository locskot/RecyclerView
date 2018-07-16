package hermes.dev.transasia.ru.sup_28026.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hermes.dev.transasia.ru.sup_28026.R;

public class VisitedPointVH extends RecyclerView.ViewHolder{

    public View viewDividerSide;
    public TextView tvId;
    public TextView tvName;
    public ImageView ivLogo;
    public TextView tvAddress;
    public TextView tvWorkingHours;
    public ImageView ivNavigation;
    public View viewDividerBottom;


    public VisitedPointVH(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        viewDividerSide = (View) itemView.findViewById(R.id.view_divider_side);
        tvId = (TextView) itemView.findViewById(R.id.tv_id);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        ivLogo = (ImageView) itemView.findViewById(R.id.iv_logo);
        tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
        tvWorkingHours = (TextView) itemView.findViewById(R.id.tv_working_hours);
        ivNavigation = (ImageView) itemView.findViewById(R.id.iv_navigation);
        viewDividerBottom = (View) itemView.findViewById(R.id.view_divider_bottom);
    }
}
