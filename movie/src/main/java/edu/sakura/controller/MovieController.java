package edu.sakura.controller;


import edu.sakura.entity.Hall;
import edu.sakura.entity.Movie;
import edu.sakura.service.MovieService;
import edu.sakura.util.GithubUploader;
import edu.sakura.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Api(tags = "电影相关模块")
@RestController  //  @Controller + @ResponseBody 后台代码  --------- Json格式数据 --------> 前台代码
// @RequestBody  前台页面 ----------- json格式的数据  -> 后台
@RequestMapping("/movie")
@CrossOrigin  // 允许跨域（前后端分离）
@Slf4j  // 日志对象，替代使用 System.out.println
public class MovieController {

    @Autowired
    private GithubUploader githubUploader;

    @Autowired
    private MovieService movieService;

    @ApiOperation("根据电影ID查询单个电影信息")
    @GetMapping("/findMovieById")
    @ApiImplicitParam(name="id", value = "电影ID", dataType = "Integer")
    public Movie findMovieById(Integer id ){
        return movieService.findOne(id);
    }

    @ApiOperation("查询电影部分信息")
    @GetMapping("/findAllMovie")
    public List<Movie> findAllMovie(){
        return movieService.findAllMovie();
    }

    @ApiOperation("查询可以用的Hall")
    @GetMapping("/findUsableHall")
    public List<Hall> findUsableHall(){
        log.info("可以用的Hall=" + movieService.findUsableHall());
        return movieService.findUsableHall();
    }

    /**
     * 处理添加电影的方法
     * @param file 图片
     * @param movie 电影信息对象
     */
    @ApiOperation("添加电影")
    @PostMapping("/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name="file", value = "图片", paramType = "form", dataType = "file"),
            @ApiImplicitParam(name="movie", value = "电影对象", dataType = "Movie")
    })
    public Result addMovie(@RequestParam("file") MultipartFile file, Movie movie) throws Exception{
        // 获得上传 img路径
        String returnPath = githubUploader.upload(file);
       /*
        log.info("存储在github图床上的地址：" + returnPath);
        log.info("file" + file);
        log.info("movie:" + movie);
        // 获取上传文件后缀名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        log.info("文件的后缀名: " + extension);
        Random random = new Random();
        String newFileName = random.nextInt(1000) + "abc" + "." + extension;
        log.info("文件的新名称：" + newFileName);
        File saveDir = new File("E:/upload_img");
        if (!saveDir.exists()) // 若目录不存在，创建
            saveDir.mkdirs();  //创建多级目录
        // 根据目录名 + 文件名创建新的file对象
        File uploadFile = new File(saveDir, newFileName);
        file.transferTo(uploadFile);
        log.info("存储在本地的: " + uploadFile.getAbsoluteFile());
        // 把磁盘上的图片存储到 github图床上去
        FileInputStream input = new FileInputStream(uploadFile);
        MultipartFile multipartFile =new MockMultipartFile("file", newFileName, "text/plain", IOUtils.toByteArray(input));
        // String returnPath = githubUploader.upload(multipartFile);
        log.info("存储在github图床上的地址：" + returnPath);
       * */
        // 把地址给movie对象
        movie.setImg(returnPath);
        log.info("movie对象的值:" + movie);
        // 添加数据库
        movieService.addMovie(movie);
        return Result.success("添加成功");
    }


    @ApiOperation(value = "分页查询电影")
    @GetMapping("/findByPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value = "当前页", dataType = "int", required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据数", dataType = "int", required = true, defaultValue = "2")
    })
    public Map<String, Object> findByPage(@RequestParam  Integer pageNum, @RequestParam  Integer pageSize){
        HashMap<String, Object> map = new HashMap<>();
        // 检测页面传递的值是否获取到了
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageNum=" + pageNum +",pageSize=" + pageSize);
        // 调用 Service中方法
        List<Movie> movieList = movieService.findByPage(pageNum, pageSize);
        // 计算总数
        Integer totals = movieService.findTotals();
        // 计算总页数  totals = 5 pageSize = 2, 整除 或 不整除
        Integer totalPage = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
        map.put("movieList", movieList);  // 数据
        map.put("totals", totals);  // 总记录数
        map.put("totalPage", totalPage);  // 总页数
        map.put("pageNum", pageNum);  // 当前页码
        return map;
    }
}
