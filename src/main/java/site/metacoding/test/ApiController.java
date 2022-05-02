package site.metacoding.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/api/weather", method = RequestMethod.GET, produces = "application/json; charset=UTF8")
    public String api_load() {
        StringBuilder sb = new StringBuilder();

        try {
            String uri = "http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=13cWFmj3zbZtaZpsP%2FhywuguJIxK1B0g5KLnbx6WFb0tNP8KkeG5%2B7kuj8MQ8hZAc%2Fc1MJoLdoQJuHXPDUALSA%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID=1";

            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                sb.append(returnLine);
            }
            urlConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}