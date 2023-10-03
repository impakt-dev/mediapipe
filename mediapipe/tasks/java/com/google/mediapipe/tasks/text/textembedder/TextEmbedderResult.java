// Copyright 2022 The MediaPipe Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.mediapipe.tasks.text.textembedder;

import com.google.auto.value.AutoValue;
import com.google.mediapipe.tasks.components.containers.EmbeddingResult;
import com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto;
import com.google.mediapipe.tasks.core.TaskResult;

/** Represents the embedding results generated by {@link TextEmbedder}. */
@AutoValue
public abstract class TextEmbedderResult implements TaskResult {

  /**
   * Creates an {@link TextEmbedderResult} instance.
   *
   * @param embeddingResult the {@link EmbeddingResult} object containing one embedding per embedder
   *     head.
   * @param timestampMs a timestamp for this result.
   */
  static TextEmbedderResult create(EmbeddingResult embeddingResult, long timestampMs) {
    return new AutoValue_TextEmbedderResult(embeddingResult, timestampMs);
  }

  /**
   * Creates an {@link TextEmbedderResult} instance from a {@link EmbeddingsProto.EmbeddingResult}
   * protobuf message.
   *
   * @param proto the {@link EmbeddingsProto.EmbeddingResult} protobuf message to convert.
   * @param timestampMs a timestamp for this result.
   */
  static TextEmbedderResult createFromProto(
      EmbeddingsProto.EmbeddingResult proto, long timestampMs) {
    return create(EmbeddingResult.createFromProto(proto), timestampMs);
  }

  /** Contains one embedding per embedder head. */
  public abstract EmbeddingResult embeddingResult();

  @Override
  public abstract long timestampMs();
}
