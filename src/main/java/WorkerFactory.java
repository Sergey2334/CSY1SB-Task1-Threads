public interface WorkerFactory<W extends Worker> {
    W create(WarehouseManager manager);
}