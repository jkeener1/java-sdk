/**
 * Copyright (c) 2011, salesforce.com, inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of salesforce.com, inc. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.force.sdk.jpa.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.force.sdk.jpa.mock.*;
import com.sforce.soap.partner.FieldType;

/**
 * Simple parent test entity used for 
 * Force.com JPA query join tests.
 *
 * @author Tim Kral
 */
@Entity
@MockApiEntity
public class BasicParentTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @MockApiField(name = "Id", type = FieldType.id, custom = false)
    private String id;
    
    @MockApiField(name = "Name", type = FieldType.string, custom = false)
    private String name;
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @MockApiRelationship(name = "BasicParentTestEntity_basicchildtestenti__r")
    private Collection<BasicChildTestEntity> childEntities;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<BasicChildTestEntity> getChildEntities() {
        return childEntities;
    }
    
    public void addChildTestEntity(BasicChildTestEntity entity) {
        if (childEntities == null) {
            childEntities = new ArrayList<BasicChildTestEntity>();
        }
        
        childEntities.add(entity);
    }
}