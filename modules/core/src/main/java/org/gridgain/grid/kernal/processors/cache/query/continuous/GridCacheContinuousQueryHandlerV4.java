/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.kernal.processors.cache.query.continuous;

import org.gridgain.grid.cache.*;
import org.gridgain.grid.cache.query.GridCacheContinuousQueryEntry;
import org.gridgain.grid.lang.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

/**
 * Continuous query handler used when "keepPortable" flag is set and security is enabled.
 */
@Deprecated
public class GridCacheContinuousQueryHandlerV4<K, V> extends GridCacheContinuousQueryHandlerV2<K, V> {
    /** */
    private static final long serialVersionUID = 0L;

    /**
     * For {@link Externalizable}.
     */
    public GridCacheContinuousQueryHandlerV4() {
        // No-op.
    }

    /**
     * @param cacheName Cache name.
     * @param topic Topic for ordered messages.
     * @param cb Local callback.
     * @param filter Filter.
     * @param prjPred Projection predicate.
     * @param internal If {@code true} then query is notified about internal entries updates.
     * @param taskHash Task hash.
     */
    public GridCacheContinuousQueryHandlerV4(@Nullable String cacheName, Object topic,
        GridBiPredicate<UUID, Collection<GridCacheContinuousQueryEntry<K, V>>> cb,
        @Nullable GridPredicate<GridCacheContinuousQueryEntry<K, V>> filter,
        @Nullable GridPredicate<GridCacheEntry<K, V>> prjPred, boolean internal, int taskHash) {
        super(cacheName, topic, cb, filter, prjPred, internal, taskHash);
    }

    /** {@inheritDoc} */
    @Override protected boolean keepPortable() {
        return true;
    }
}