package com.smartgeek.component.mapping;

/**
 * @author cys
 * @date 2022/11/27 18:23
 * @description:
 */
public interface ModelMappingI<C, E, P> {
    C entityToClient(E entityObject);

    P entityToPersistence(E entityObject);

    C persistenceToClient(P persistenceObject);

    E persistenceToEntity(P persistenceObject);

    E clientToEntity(C clientObject);
}
