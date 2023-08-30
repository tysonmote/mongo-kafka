/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Original Work: Apache License, Version 2.0, Copyright 2017 Hans-Peter Grahsl.
 */

package com.rippling.kafka.connect.sink.processor;

import static com.rippling.kafka.connect.sink.MongoSinkTopicConfig.FieldProjectionType.BLOCKLIST;
import static com.rippling.kafka.connect.sink.MongoSinkTopicConfig.KEY_PROJECTION_LIST_CONFIG;

import com.rippling.kafka.connect.sink.MongoSinkTopicConfig;
import com.rippling.kafka.connect.sink.processor.field.projection.BlockListProjector;

public class BlockListKeyProjector extends BlockListProjector {

  public BlockListKeyProjector(final MongoSinkTopicConfig config) {
    this(config, config.getString(KEY_PROJECTION_LIST_CONFIG));
  }

  public BlockListKeyProjector(final MongoSinkTopicConfig config, final String fieldList) {
    super(config, buildProjectionList(BLOCKLIST, fieldList), SinkDocumentField.KEY);
  }
}
