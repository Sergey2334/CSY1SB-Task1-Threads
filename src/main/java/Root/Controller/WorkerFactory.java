package Root.Controller;

import Root.Model.WarehouseManager;
import Root.Model.Worker;

public interface WorkerFactory<W extends Worker> {
    W create(WarehouseManager manager);
}