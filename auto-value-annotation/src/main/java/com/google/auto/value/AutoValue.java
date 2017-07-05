/*
 * Copyright (C) 2012 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.auto.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is a copy of the AutoValue annotation in the auto-value library.
 *
 * Since we're specifying the auto-value library as an "apt" dependency (annotation processor), we can't reference any classes in the library from
 * our application code -- we can only reference the code that it generates. As a result, the AutoValue annotation (the one that this is copied
 * from) isn't visible to application code, and the app won't compile. By including the AutoValue annotation separately in the project, we can
 * still use the AutoValue annotation as intended while keeping the auto-value annotation processor as an "apt" dependency (so long as the package
 * name of the AutoValue annotation is the same -- com.google.auto.value). Apparently in auto-value version 1.2, the AutoValue annotation will be
 * a separate dependency and we won't need this workaround. See the issue here: https://github.com/google/auto/issues/268.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface AutoValue {

    /**
     * Specifies that AutoValue should generate an implementation of the annotated class or interface,
     * to serve as a <i>builder</i> for the value-type class it is nested within. As a simple example,
     * here is an alternative way to write the {@code Person} class mentioned in the {@link AutoValue}
     * example: <pre>
     *
     *   &#64;AutoValue
     *   abstract class Person {
     *     static Builder builder() {
     *       return new AutoValue_Person.Builder();
     *     }
     *
     *     abstract String name();
     *     abstract int id();
     *
     *     &#64;AutoValue.Builder
     *     interface Builder {
     *       Builder name(String x);
     *       Builder id(int x);
     *       Person build();
     *     }
     *   }</pre>
     *
     * @author Éamonn McManus
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.TYPE)
    public @interface Builder {
    }
}
