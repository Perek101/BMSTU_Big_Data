package org.example;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;



public class Main {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("RandomSplitExample")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> data = spark.read().format("csv")
                .option("header", "true")
                .load("/Users/lol/Desktop/untitled/Lab10___/coinbase-extracted-second.csv");
        data.createOrReplaceTempView("coinbase");
        spark.sql("select * from coinbase ").show();
        spark.sql("select * from coinbase where coinbase.Symbol='USDT'").show();
        spark.sql("select coinbase.Symbol, AVG(coinbase.Open)  from coinbase group by coinbase.Symbol ").show();
        spark.sql("select coinbase.Symbol, date_trunc('week',coinbase.Datetime) as weeks, sum(coinbase.Open ) as total_usd from coinbase  group by 1,2").show();
        spark.sql("select * from coinbase where coinbase.Symbol='USDT' order by coinbase.High desc").show();
        spark.sql("select * from coinbase order by 4").show();
        spark.sql("select coinbase.Datetime, coinbase.Symbol, coinbase.Close from coinbase where coinbase.Symbol='USDT' and coinbase.Low < 1 group by 1,2,3 order by 1").show();
        spark.sql("select coinbase.Symbol, date_trunc('week',coinbase.Datetime) as weeks, sum(coinbase.Open ) as total_usd from coinbase where coinbase.Symbol in ('USDC', 'USDT', 'DAI','BUSD','TUSD','FRAX','USDP','USDD') group by 1,2").show();

        // Останавливаем SparkSession
        spark.stop();



    }
}