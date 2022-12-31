package com.smartgeek.component.operation;

/**
 * @author cys
 */
@SuppressWarnings("unchecked")
public abstract class EntityOperations {

  public static <T> EntityUpdater<T> doUpdate(BaseRepository<T > crudPort) {
    return new EntityUpdater<>(crudPort);
  }

  public static <T>  EntityCreator<T> doCreate(BaseRepository<T > crudPort) {
    return new EntityCreator(crudPort);
  }


}
