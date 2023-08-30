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
 */

package com.rippling.kafka.connect.sink.converter;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.errors.DataException;

import org.bson.BsonDocument;
import org.bson.RawBsonDocument;
import org.bson.codecs.BsonDocumentCodec;

/** Used for converting Bson byte arrays */
class ByteArrayRecordConverter implements RecordConverter {

  private static final BsonDocumentCodec BSON_DOCUMENT_CODEC = new BsonDocumentCodec();

  @Override
  public BsonDocument convert(final Schema schema, final Object value) {
    if (value == null) {
      throw new DataException("Value was null for BSON conversion");
    }

    return new RawBsonDocument((byte[]) value).decode(BSON_DOCUMENT_CODEC);
  }
}
