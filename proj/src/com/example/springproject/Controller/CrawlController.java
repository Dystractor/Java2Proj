package com.example.springproject.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.springproject.Entity.Commits;
import com.example.springproject.Entity.Developers;
import com.example.springproject.Entity.Issues;
import com.example.springproject.Entity.Releases;
import com.example.springproject.service.CommitsService;
import com.example.springproject.service.DevelopersService;
import com.example.springproject.service.IssuesService;
import com.example.springproject.service.ReleasesService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class CrawlController {
    @Autowired
    private DevelopersService developersService;

    @Autowired
    private CommitsService commitsService;
    @Autowired
    private IssuesService issuesService;
    @Autowired
    private ReleasesService releasesService;

    @GetMapping("/crawl")
    public String registerBack() {
        return "crawl";
    }


    @RequestMapping("/crawl")
    public void getter(@RequestParam("username1") String username, @RequestParam("date1") String date, Model model) throws IOException, ParseException, InterruptedException {
        //contributors
        String s = "https://api.github.com/repos/";
        s += username + "/" + date + "/";
        s += "contributors?per_page=100&page=";

        String ss = s;
        int cnt = 0;
        while (true) {
            ++cnt;
            String now = Integer.toString(cnt);
            s = ss;
            s += now;
            Thread.sleep(1000);
            URL url = new URL(s);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String jsonString = "" + baos.toString() + "";
            baos.close();
            inputStream.close();
            conn.disconnect();
            JSONArray array = new JSONArray(jsonString);
            if (array.length() == 0) break;
            for (int i = 0; i < array.length(); ++i) {
                JSONObject jsonObject = array.getJSONObject(i);
                Developers current = new Developers();
                current.setUserId(Integer.toString(jsonObject.getInt("id")));
                String username2 = jsonObject.getString("login");
                current.setUsername(jsonObject.getString("login"));
                //System.out.println(jsonObject.getInt("id")+","+jsonObject.getString("login"));
                if (developersService.findByUsername(username2) == null)
                    developersService.save(current);
            }
        }

//
//    //issues
        s = "https://api.github.com/repos/";
        s += username + "/" + date + "/";
        s += "issues?per_page=100&page=";
        ss = s;
        cnt = 0;
        while (true) {
            ++cnt;
            String now = Integer.toString(cnt);
            s = ss;
            s += now;
            s += "&state=closed";
            Thread.sleep(1000);
            URL url = new URL(s);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String jsonString = "" + baos.toString() + "";
            baos.close();
            inputStream.close();
            conn.disconnect();
            JSONArray array = new JSONArray(jsonString);
            if (array.length() == 0) break;
            for (int i = 0; i < array.length(); ++i) {
                JSONObject jsonObject = array.getJSONObject(i);
                Issues current = new Issues();
                String state = jsonObject.getString("state");
                if (state.equals("open"))
                    current.setState(true);
                else
                    current.setState(false);
                current.setIssueName(jsonObject.getString("title"));
                current.setIssueId(Integer.toString(jsonObject.getInt("id")));
                current.setStartDate(jsonObject.getString("created_at"));
                if (state.equals("closed"))
                    current.setEndDate(jsonObject.getString("closed_at"));
                //TODO
                //这里你写一下period的处理
                if (state.equals("closed")) {
                    String start = current.getStartDate().replaceAll("T"," ").replaceAll("Z","");
                    String end = current.getEndDate().replaceAll("T"," ").replaceAll("Z","");

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d1 = format.parse(start);
                    Date d2 = format.parse(end);
                    long diff = d2.getTime() - d1.getTime();
                    long diffMinutes = diff / (60 * 1000) % 60;
                    long diffHours = diff / (60 * 60 * 1000) % 24;
                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    String period =  (diffHours + diffDays * 24) + "h " + diffMinutes+"min";
                    current.setPeriod(period);
                }
                issuesService.save(current);
            }
        }


        s = "https://api.github.com/repos/";
        s += username + "/" + date + "/";
        s += "issues?per_page=100&page=";
        ss = s;
        cnt = 0;
        while (true) {
            ++cnt;
            String now = Integer.toString(cnt);
            s = ss;
            s += now;
            s += "&state=open";
            Thread.sleep(1000);
            URL url = new URL(s);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String jsonString = "" + baos.toString() + "";
            baos.close();
            inputStream.close();
            conn.disconnect();
            JSONArray array = new JSONArray(jsonString);
            if (array.length() == 0) break;
            for (int i = 0; i < array.length(); ++i) {
                JSONObject jsonObject = array.getJSONObject(i);
                Issues current = new Issues();
                String state = jsonObject.getString("state");
                if (state.equals("open"))
                    current.setState(true);
                else
                    current.setState(false);
                current.setIssueName(jsonObject.getString("title"));
                current.setIssueId(Integer.toString(jsonObject.getInt("id")));
                current.setStartDate(jsonObject.getString("created_at"));
                if (state.equals("closed"))
                    current.setEndDate(jsonObject.getString("closed_at"));
                issuesService.save(current);
            }
        }

        //releases
        s = "https://api.github.com/repos/";
        s += username + "/" + date + "/";
        s += "releases?per_page=100&page=";
        ss = s;
        cnt = 0;
        while (true) {
            ++cnt;
            String now = Integer.toString(cnt);
            s = ss;
            s += now;
            Thread.sleep(3000);
            URL url = new URL(s);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String jsonString = "" + baos.toString() + "";
            baos.close();
            inputStream.close();
            conn.disconnect();
            JSONArray array = new JSONArray(jsonString);
            if (array.length() == 0) break;
            for (int i = 0; i < array.length(); ++i) {
                JSONObject jsonObject = array.getJSONObject(i);
                Releases current = new Releases();
                current.setReleaseId(Integer.toString(jsonObject.getInt("id")));
                String time = jsonObject.getString("published_at");
                time = time.replace("Z", " UTC");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
                Date date1 = sdf.parse(time);
                current.setReleaseTime(date1);
                releasesService.save(current);
            }
        }

        //commits

        s = "https://api.github.com/repos/";
        s += username + "/" + date + "/";
        s += "commits?per_page=100&page=";
        ss = s;
        cnt = 0;
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
        while (true) {
            ++cnt;
            String now = Integer.toString(cnt);
            s = ss;
            s += now;
            Thread.sleep(10000);
            URL url = new URL(s);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String jsonString = "" + baos.toString() + "";
            baos.close();
            inputStream.close();
            conn.disconnect();
            JSONArray array = new JSONArray(jsonString);
            if (array.length() == 0) break;
            for (int i = 0; i < array.length(); ++i) {
                JSONObject jsonObject = array.getJSONObject(i);
                Commits current = new Commits();

                JSONObject jsonObject2 = jsonObject.getJSONObject("commit");
                JSONObject jsonObject3 = jsonObject2.getJSONObject("committer");
                if(!jsonObject.isNull("committer")) {
                    JSONObject jsonObject1 = jsonObject.getJSONObject("committer");
                    current.setCommitterId(Integer.toString(jsonObject1.getInt("id")));
                }

                String time = jsonObject3.getString("date");
                time = time.replace("Z", " UTC");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
                Date date1 = sdf.parse(time);
                System.out.println(date1);
                current.setCommitDate(date1);
                commitsService.save(current);
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}
