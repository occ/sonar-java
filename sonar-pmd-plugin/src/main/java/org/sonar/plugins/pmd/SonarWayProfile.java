/*
 * Sonar Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.pmd;

import com.google.common.io.Closeables;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Java;
import org.sonar.api.utils.ValidationMessages;

import java.io.InputStreamReader;
import java.io.Reader;

public final class SonarWayProfile extends ProfileDefinition {
  private final PmdProfileImporter importer;

  public SonarWayProfile(PmdProfileImporter importer) {
    this.importer = importer;
  }

  @Override
  public RulesProfile createProfile(ValidationMessages validation) {
    Reader config = null;
    try {
      config = new InputStreamReader(this.getClass().getResourceAsStream("/org/sonar/plugins/pmd/profile-sonar-way.xml"));

      RulesProfile profile = importer.importProfile(config, validation);
      profile.setLanguage(Java.KEY);
      profile.setName(RulesProfile.SONAR_WAY_NAME);

      return profile;
    } finally {
      Closeables.closeQuietly(config);
    }
  }
}
