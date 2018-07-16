package hermes.dev.transasia.ru.sup_28026;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hermes.dev.transasia.ru.sup_28026.model.DeliveryPoint;
import hermes.dev.transasia.ru.sup_28026.model.DeliveryPointNotVisited;
import hermes.dev.transasia.ru.sup_28026.model.DevPoint;
import hermes.dev.transasia.ru.sup_28026.model.Header;
import hermes.dev.transasia.ru.sup_28026.vh.HeaderVH;
import hermes.dev.transasia.ru.sup_28026.vh.VisitedPointVH;

public class DeliveryPointsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<DevPoint> points;
    private final static int HEADER = 0;
    private final static int VISITED = 1;
    private final static int NOT_VISITED = 2;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == VISITED) {
            rootView = inflater.inflate(R.layout.vh_delivery_point_visited, parent, false);
            viewHolder = new VisitedPointVH(rootView);
        } else if (viewType == NOT_VISITED) {
            rootView = inflater.inflate(R.layout.vh_delivery_point_not_visited, parent, false);
            viewHolder = new VisitedPointVH(rootView);
        } else {
            rootView = inflater.inflate(R.layout.vh_delivery_point_header, parent, false);
            viewHolder = new HeaderVH(rootView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder.getItemViewType() == VISITED) {
            VisitedPointVH vh1 = (VisitedPointVH) holder;
            bindVisited(vh1, position);
        } else if (holder.getItemViewType() == NOT_VISITED) {
            VisitedPointVH vh2 = (VisitedPointVH) holder;
            bindNotVisited(vh2, position);
        } else {
            HeaderVH vh3 = (HeaderVH) holder;
            bindHeader(vh3, position);
        }
    }

    private void bindVisited(VisitedPointVH holder, int position) {
        DeliveryPoint point = (DeliveryPoint) points.get(position);
        holder.tvName.setText(point.getName());
    }

    private void bindNotVisited(VisitedPointVH holder, int position) {
        DeliveryPointNotVisited point = (DeliveryPointNotVisited) points.get(position);
        holder.tvName.setText(point.getName());
    }

    private void bindHeader(HeaderVH holder, int position) {
        Header point = (Header) points.get(position);
        holder.tvTitle.setText(point.getTitle());
    }

    @Override
    public int getItemViewType(int position) {
        if (points.get(position) instanceof DeliveryPoint) {
            return VISITED;
        } else if (points.get(position) instanceof DeliveryPointNotVisited) {
            return NOT_VISITED;
        } else {
            return HEADER;
        }
    }

    @Override
    public int getItemCount() {
        return points == null ? 0 : points.size();
    }

    public void setPoints(List<DevPoint> points) {
        this.points = points;
        notifyDataSetChanged();
    }
}
