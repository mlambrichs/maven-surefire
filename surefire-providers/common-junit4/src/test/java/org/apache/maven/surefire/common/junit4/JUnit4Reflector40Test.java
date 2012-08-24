package org.apache.maven.surefire.common.junit4;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;

/**
 * @author Kristian Rosenvold
 */
public class JUnit4Reflector40Test
    extends TestCase
{
    @Test
    public void testGetAnnotatedIgnore()
    {
        JUnit4Reflector reflector = new JUnit4Reflector();
        Description desc = Description.createTestDescription( IgnoreWithDescription.class, "testSomething2" );
        Ignore annotatedIgnore = reflector.getAnnotatedIgnore( desc );
        Assert.assertNull( annotatedIgnore );
    }

    private static final String reason = "Ignorance is bliss";

    public static class IgnoreWithDescription
    {

        @Test
        @Ignore( reason )
        public void testSomething2()
        {
        }
    }
}


