package com.example.demokafka.model;

import com.example.demokafka.entity.SampleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SampleModel extends SampleEntity {
}
