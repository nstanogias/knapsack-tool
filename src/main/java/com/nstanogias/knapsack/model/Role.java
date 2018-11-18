package com.nstanogias.knapsack.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "roles")
@Data
@NoArgsConstructor
public class Role  {
    private RoleName name;
}
