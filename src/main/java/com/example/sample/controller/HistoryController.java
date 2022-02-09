package com.example.sample.controller;
import com.example.sample.model.entity.K8sHistory;
import com.example.sample.service.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/histories")
public class HistoryController {

  HistoryService historyService;
  public HistoryController(HistoryService historyService) {
    this.historyService = historyService;
  }

  @GetMapping("")
  public List<K8sHistory> getHistories(){
    return historyService.getHistories();
  }

  // TODO: insert를 client가 post 하는 방식이 아니라, kube-watch 받아와서 저장 하는 형식으로 변경
  // restapi 설계시 url에 행위를 표현하는건 최대한 피해야합니다.
  // Post 라는 메서드는 이미 insert라는 행위를 하기로 약속되어있습니다.
  @PostMapping("")
  public ResponseEntity insertHistory(@RequestBody Map<String,Object> historyData){
      K8sHistory history = new K8sHistory();
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      history.setTime(timestamp);
      history.setKind(historyData.get("kind").toString());
      history.setNamespace(historyData.get("namespace").toString());
      history.setName(historyData.get("name").toString());
      history.setCmd(historyData.get("cmd").toString());
      K8sHistory response = historyService.insertHistory(history);
      return new ResponseEntity(response, HttpStatus.CREATED);
  }
  // TODO: webhook receiver 테스트
  // https://github.com/bitnami-labs/kubewatch/blob/84a34db93ff9935ce133f4eb1175187154253685/pkg/handlers/webhook/webhook.go#L113
  // 코드 보면 그냥 post request 보내주는데 왜 못받아오는지 모르겠네요,,(직접 날리면 받아옴, configmap 수정했음)
  @PostMapping("/listener")
  public void getMyJson(@RequestBody Map<String, Object> json){
      System.out.println("This is " + json);
  }

}
