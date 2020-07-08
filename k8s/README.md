# kustomize dry run
In order to be able to produce a kustomize output without applying it to the environment directly run the following
command redirecting the output to a file for reviewing it

```demo-app-config $ kubectl kustomize local > local.yml```

# kustomize apply
In order to apply the kustomize configuration you have two options. 

#### Apply the produced file
```demo-app-config $ kubectl apply -f local.yml```

In this case in order to revert the changes produced by this deployment, run: 

```demo-app-config $ kubectl delete -f local.yml```

#### Apply directly based on the desired environment
```demo-app-config $ kubectl apply -k local```

In this case in order to revert the changes produced by this deployment, run:

```demo-app-config $ kubectl delete -k local```