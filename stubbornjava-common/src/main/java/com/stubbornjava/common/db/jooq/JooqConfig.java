package com.stubbornjava.common.db.jooq;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.util.jaxb.ForcedType;

import com.google.common.collect.Lists;

public class JooqConfig {

    public static DefaultConfiguration defaultConfigFromDataSource(DataSource ds) {
        DataSourceConnectionProvider dcp = new DataSourceConnectionProvider(ds);
        DefaultConfiguration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(SQLDialect.MYSQL);
        jooqConfig.set(dcp);
        return jooqConfig;
    }

    public static List<ForcedType> defaultForcedTypes() {
        return Lists.newLinkedList(Arrays.asList(new ForcedType[] {
                new ForcedType()
                    .withName("BOOLEAN")
                    .withTypes("tinyint")
        }));
    }
}
