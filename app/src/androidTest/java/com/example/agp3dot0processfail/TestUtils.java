package com.example.agp3dot0processfail;

import com.google.auto.value.AutoValue;

public class TestUtils {

    public static void setupServer(final String startState, final String endState) {
        //... some setup
    }

    @AutoValue
    public static abstract class TestSetupConfig {

        public static Builder builder() {
            return new AutoValue_TestUtils_TestSetupConfig.Builder();
        }

        public static TestSetupConfig defaults() {
            return builderWithDefaults().build();
        }

        static Builder builderWithDefaults() {
            return builder()
                       .feature1(false);
        }

        abstract boolean eligibleForReferAFriend();

        @AutoValue.Builder
        static abstract class Builder {
            abstract Builder feature1(boolean feature1);

            abstract TestSetupConfig build();
        }
    }

}
