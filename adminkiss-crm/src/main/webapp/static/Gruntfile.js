module.exports = function (grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        // 提取依赖
        transport: {
            options: {
                paths: ['.'],
                alias: '<%= pkg.spm.alias %>'
            },
            mod: {
                options: {
                    idleading: 'dist/mods/'
                },
                files: [{
                    cwd: 'assets/mods', // 需要提取依赖文件的相对路径
                    src: ['**/*'], // 需要提取依赖的文件
                    filter: 'isFile',
                    dest: '.build/mods' // 提取后存放的临时文件夹
                }]
            },
            adminkiss: {
                options: {
                    idleading: 'dist/apps/'
                },
                files: [
                    {
                        cwd: 'assets/apps',
                        src: '**/*',
                        filter: 'isFile',
                        dest: '.build/apps'
                    }
                ]
            }
        },
        // 合并
        concat: {
            options: {
                paths: ['.'],
                include: 'relative'
            },
            mod: {
                files: [{
                    expand: true,
                    cwd: '.build/', // 需要合并的文件夹路径
                    src: ['mods/**/*.js'], // 需要合并的文件
                    dest: 'dist/', // 合并后存放的路径
                    ext: '.js' // 合并后的扩展名
                }]
            },
            adminkiss: {
                options: {
                    include: 'all'
                },
                files: [
                    {
                        expand: true,
                        cwd: '.build/',
                        src: ['apps/**/*.js'],
                        dest: 'dist/',
                        ext: '.js'
                    }
                ]
            }
        },
        // 压缩
        uglify: {
            mod: {
                files: [{
                    expand: true,
                    cwd: 'dist/', // 需要压缩的文件夹路径
                    src: ['mods/**/*.js', '!mods/**/*-debug.js', '!libs/**/*'], // 需要压缩的文件
                    dest: 'dist/', // 压缩后存放的路径
                    ext: '.js' // 压缩后的扩展名
                }]
            },
            adminkiss: {
                files: [
                    {
                        expand: true,
                        cwd: 'dist/',
                        src: ['apps/**/*.js', '!apps/**/*-debug.js'],
                        dest: 'dist/',
                        ext: '.js'
                    }
                ]
            }
        },
        // 清除临时文件
        clean: {
            spm: ['.build'] // 需要清除的文件夹名称
        },
        cssmin: {
            options: {
                banner: '/* <%= grunt.template.today("yyyy-mm-dd HH:MM") %> */'
            },
            combine: {
                files: {
                    'dist/css/adminkiss-common.css': [
                  'assets/css/bootstrap.min.css', // 基础样式
                  'assets/css/font-awesome.min.css', // 图标
                  'assets/css/mods/nprogress.css', // 进度条
                  'assets/css/mods/message.css', // 消息框
                  'assets/css/mods/color.css', // 颜色
                  'assets/css/mods/animations.css', // 动画效果
                        'assets/css/adminkiss-form.css'
              ],
                    'dist/css/adminkiss-login.css': [
                  'assets/css/adminkiss-login.css'
              ],
                    'dist/css/adminkiss-main.css': [
                  'assets/css/adminkiss-main.css'
              ],
                }
            }
        },
        copy: {
            main: {
                files: [
                    {
                        expand: true,
                        cwd: 'assets/images/',
                        src: ['**'],
                        dest: 'dist/images/'
                    },
                    {
                        expand: true,
                        cwd: 'assets/fonts/',
                        src: ['**'],
                        dest: 'dist/fonts/'
                    },
                    {
                        expand: true,
                        cwd: 'assets/sound/',
                        src: ['**'],
                        dest: 'dist/sound/'
                    }
            ]
            }
        },
        watch: {
            files: '**/*',
            tasks: ['default']
        }
    });

    // 所依赖的组件 S
    grunt.loadNpmTasks('grunt-cmd-transport');
    grunt.loadNpmTasks('grunt-cmd-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');
    // 所依赖的组件 E
    grunt.registerTask('build-mod', ['transport:mod', 'concat:mod', 'uglify:mod', 'clean']);
    grunt.registerTask('build-kiss', ['transport:adminkiss', 'concat:adminkiss', 'uglify:adminkiss', 'clean']);
    grunt.registerTask('build-css', ['cssmin', 'copy', 'watch']);
    grunt.registerTask('default', ['clean']); //默认任务

}