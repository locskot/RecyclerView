package hermes.dev.transasia.ru.sup_28026;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hermes.dev.transasia.ru.sup_28026.model.DevPoint;
import hermes.dev.transasia.ru.sup_28026.model.Header;
import hermes.dev.transasia.ru.sup_28026.model.DeliveryPointNotVisited;
import hermes.dev.transasia.ru.sup_28026.model.DeliveryPoint;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private DeliveryPointsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupRecycler();
        adapter.setPoints(displayPoints());
    }

    public List<DevPoint> getAllPoints() {
        List<DevPoint> list = new ArrayList<>();
        list.add(new DeliveryPointNotVisited("store 1", 1));
        list.add(new DeliveryPointNotVisited("store 2", 2));
        list.add(new DeliveryPointNotVisited("store 3", 3));
        list.add(new DeliveryPointNotVisited("store 4", 4));
        list.add(new DeliveryPointNotVisited("store 5", 5));
        list.add(new DeliveryPointNotVisited("store 6", 6));
        return list;
    }

    public List<DevPoint> getVisited() {
        List<DevPoint> list = new ArrayList<>();
        list.add(new DeliveryPoint("store 3", 3));
        list.add(new DeliveryPoint("store 4", 4));
        return list;
    }

    public List<DevPoint> getNotVisitedList() {
        List<DevPoint> visited = getVisited();
        List<DevPoint> allPoints = getAllPoints();

        for (int i = 0; i < visited.size(); i++) {
            DeliveryPoint di = (DeliveryPoint) visited.get(i);
            for (int j = 0; j < allPoints.size(); j++) {
                DeliveryPointNotVisited dj = (DeliveryPointNotVisited) allPoints.get(j);
                if (di.getId() == dj.getId()) allPoints.remove(dj);
            }
        }
        return allPoints;
    }

    public List<DevPoint> displayPoints() {
        List<DevPoint> list = new ArrayList<>();
        if (getNotVisitedList() != null) {
            if (getNotVisitedList().size() != 0) {
                list.add(new Header("Не посещенные точки", 9));
                list.addAll(getNotVisitedList());
            }
        }

        if (getVisited().size() != 0) {
            list.add(new Header("Посещенные точки", 10));
            list.addAll(getVisited());
        }

        return list;
    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }

    private void setupRecycler() {
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DeliveryPointsAdapter();
        recycler.setAdapter(adapter);
    }

}
