package com.smartgeek.component.operation;

/**
 * @author cys
 */
@SuppressWarnings("unchecked")
public abstract class EntityOperations {

  public static <T,ID> EntityUpdater<T,ID> doUpdate(CrudPort<T, ID > crudPort) {
    return new EntityUpdater<>(crudPort);
  }

  public static <T,ID>  EntityCreator<T,ID> doCreate(CrudPort<T, ID > crudPort) {
    return new EntityCreator(crudPort);
  }


}
