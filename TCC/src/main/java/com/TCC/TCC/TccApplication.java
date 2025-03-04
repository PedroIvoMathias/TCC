package com.TCC.TCC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TccApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
//		Config helloWorldConfig = new Config();
//		helloWorldConfig.setClusterName("hello-world");
//
//		JetConfig jetConfig = helloWorldConfig.getJetConfig();
//		jetConfig.setEnabled(true);
//
//		HazelcastInstance hz = Hazelcast.newHazelcastInstance(helloWorldConfig);
//		HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(helloWorldConfig);
//		HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(helloWorldConfig);
//
//		SqlService sql = hz.getSql();
//
//		String createMappingQuery = "CREATE MAPPING myDistributedMap\n" + "TYPE IMap\n"
//				+ "OPTIONS ('keyFormat'='varchar','valueFormat'='varchar')";
//		sql.execute(createMappingQuery);
//
//		List<String> insertionQueries = Arrays.asList("SINK INTO myDistributedMap VALUES('1', 'John')",
//				"SINK INTO myDistributedMap VALUES('2', 'Mary')", "SINK INTO myDistributedMap VALUES('3', 'Jane')");
//		for (String insertionQuery : insertionQueries) {
//			sql.execute(insertionQuery);
//		}
//
//		String scanQuery = "SELECT * FROM myDistributedMap";
//		try (SqlResult result = sql.execute(scanQuery)) {
//			int columnCount = result.getRowMetadata().getColumnCount();
//			for (SqlRow row : result) {
//				for (int colIdx = 0; colIdx < columnCount; colIdx++) {
//					System.out.print(row.getObject(colIdx) + " ");
//				}
//				System.out.println();
//			}
//		}
	}
}
