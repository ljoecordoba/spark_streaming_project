package aws

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import java.util
import java.util.Random


class S3Writer {
  var credentials = new BasicAWSCredentials(
    "AKIA6CM2WR6UI46RMI5I",
    "rgEVZC+NtPo89mmdr392kZM1Lh+ncYSsiaZV4dgi"
  );
  val s3Client = AmazonS3ClientBuilder
    .standard()
    .withCredentials(new AWSStaticCredentialsProvider(credentials))
    .withRegion(Regions.US_WEST_2)
    .build()

  def write(list: List[String]): Unit = {

    var random = new Random
    var totalString = ""
    for (a <- list){
      totalString += a
    }
    s3Client.putObject(
      "nuevo-bucket-para-kafka",
      "20191205/"+random.nextInt(1000),
      totalString
    )
  }


}
