/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marin.presto.plugin.phoenix;

import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import javax.inject.Inject;

import com.facebook.presto.plugin.jdbc.BaseJdbcClient;
import com.facebook.presto.plugin.jdbc.BaseJdbcConfig;
import com.facebook.presto.plugin.jdbc.JdbcConnectorId;
import org.apache.phoenix.jdbc.PhoenixDriver;

public class PhoenixClient
        extends BaseJdbcClient
{
    @Inject
    public PhoenixClient(JdbcConnectorId connectorId, BaseJdbcConfig config)
            throws SQLException
    {
        super(connectorId, config, "\"", new PhoenixDriver());
    }

    @Override
    public Set<String> getSchemaNames()
    {
        Set<String> def = new HashSet<>();
        def.add("default");
        return def;
    }
}