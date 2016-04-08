Demo cluster which shows RTC client read/write scenario + POF serialization + eviction

1)CacheServer
com.examples.CacheServer
-Dtangosol.coherence.cacheconfig="cachesrv/example-config.xml"


2)ProxyServer
com.examples.CacheServer
-Dtangosol.coherence.cacheconfig="proxy/example-config.xml"


3)RealTimeClient
com.examples.RealTimeClient
-Dtangosol.coherence.override="rtc/tangosol-coherence-override.xml"
-Dtangosol.coherence.cacheconfig="rtc/example-config.xml"
-Dtangosol.coherence.cluster=newCluster
-Dtangosol.coherence.localhost=localhost
-Dtangosol.coherence.localport=9888
-Dtangosol.coherence.ttl=0
